/*Adapted from Dr Ian Coopers "Students.sql" tutorial document (Week4)*/
/*Initial layout script written by Anj Ramayead 12/12/2020*/


DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS TrainerUser;
DROP TABLE IF EXISTS Video;
DROP TABLE IF EXISTS Sys_Admin;


--CREATE TABLE IF NOT EXISTS 'User' ();


--CREATE TABLE IF NOT EXISTS 'TrainerUser' ();



CREATE TABLE IF NOT EXISTS 'Video'(
'ID'	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
'name'	VARCHAR(600),
'url'	VARCHAR(600),
'description'	VARCHAR(600),
'title' VARCHAR(600)
);




-- ----------------------------
-- Table structure for details
-- ----------------------------
DROP TABLE IF EXISTS `details`;
CREATE TABLE `details`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `height` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `level` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `organisation` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `qualification` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `speciality` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `weight` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;


-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int NOT NULL,
  `content` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;


--INSERT INTO 'TrainerUser'();



--INSERT INTO 'Video'();



--INSERT INTO 'System_Admin'();



--------------------------------------------------------

-- UPDATE 'User' ();

-- UPDATE 'TrainerUser'(); 

-- UPDATE 'Video'();

-- UPDATE 'Sys_Admin'();


---------------------------------------------------------



--Select statements--

--

CREATE TABLE IF NOT EXISTS `test`.`routines` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `routine_name` VARCHAR(45) NOT NULL,
  `trainer_id` BIGINT(20) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `trainer_id_foreign_idx` (`trainer_id` ASC),
  CONSTRAINT `trainer_id_foreign`
    FOREIGN KEY (`trainer_id`)
    REFERENCES `test`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE IF NOT EXISTS `test`.`videos_routines` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `video_id` INT NOT NULL,
  `routine_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `video_id_idx` (`video_id` ASC),
  INDEX `routine_id_idx` (`routine_id` ASC),
  CONSTRAINT `video_id`
    FOREIGN KEY (`video_id`)
    REFERENCES `test`.`video` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `routine_id`
    FOREIGN KEY (`routine_id`)
    REFERENCES `test`.`routines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;