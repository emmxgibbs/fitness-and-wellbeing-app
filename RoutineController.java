package com.team4.fitness_and_wellbeing.Controller;

import com.team4.fitness_and_wellbeing.Dao.RoutineDao;
import com.team4.fitness_and_wellbeing.Dao.VideosRoutinesDao;
import com.team4.fitness_and_wellbeing.Login.RoutineRepository;
import com.team4.fitness_and_wellbeing.Login.VideosRoutinesRepository;
import com.team4.fitness_and_wellbeing.model.RoutineForm;
import com.team4.fitness_and_wellbeing.model.UserDto;
import com.team4.fitness_and_wellbeing.model.Video;
import com.team4.fitness_and_wellbeing.service.MyUserDetailsService;
import com.team4.fitness_and_wellbeing.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoutineController {
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private RoutineRepository routineRepository;

    @Autowired
    private VideosRoutinesRepository videosRoutinesRepository;

    @RequestMapping(path = "/getVideosForUser", method = RequestMethod.GET)
    public ResponseEntity<?> getVideosForRoutine() {
        try {
            //get user details
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            UserDto currentUser = this.userDetailsService.getCurrentUserProfileInfo(username);

            //get the user's videos
            List<Video> userVideos = videoService.selectVideo();

            return ResponseEntity.ok(userVideos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.ok("/login");
        }
    }

    @RequestMapping(path = "/routine", method = RequestMethod.POST)
    public ResponseEntity<?> createRoutine(@RequestBody RoutineForm routineForm) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        UserDto currentUser = this.userDetailsService.getCurrentUserProfileInfo(username);

        // create a new routine in the DB, set fields
        RoutineDao newRoutine = new RoutineDao();
        newRoutine.setRoutineName(routineForm.getName());
        newRoutine.setTrainerId(currentUser.getUserIdAsLong());

        // save the new routine in the DB
        RoutineDao created = this.routineRepository.save(newRoutine);

        // for each video ID in the videoIdList, verify the video exists & create a record in
        // the videos_routines pivot table associated with the new routine ID
        for (Integer integer : routineForm.getVideoIdList()) {
            VideosRoutinesDao pivotRecord = new VideosRoutinesDao();
            pivotRecord.setRoutineId(created.getId());
            pivotRecord.setVideoId(integer);

            this.videosRoutinesRepository.save(pivotRecord);
        }
        return ResponseEntity.ok(null);
    }

    @RequestMapping(path = "/routines", method = RequestMethod.GET)
    public ResponseEntity<?> getRoutines() {
        try {
            //get user details
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            UserDto currentUser = this.userDetailsService.getCurrentUserProfileInfo(username);

            //get the user's routines
            List<RoutineDao> userRoutines = this.routineRepository.getRoutinesForTrainer(
                    currentUser.getUserIdAsLong()
            );

            // todo: get videos associated with each routine
//            List<Video> routineVideos = this.videoService.getVideos(new HashSet<>(Arrays.asList(1)));
//            System.out.println(routineVideos.get(0).getTitle());

            return ResponseEntity.ok(userRoutines);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.ok("/login");
        }
    }
}
