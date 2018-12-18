CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `address` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `process_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dead_rule` varchar(200) DEFAULT NULL,
  `ip` varchar(64) NOT NULL,
  `kill_cmd` varchar(200) DEFAULT NULL,
  `log_file` varchar(200) DEFAULT NULL,
  `main` varchar(200) NOT NULL,
  `province` varchar(128) NOT NULL,
  `psword` varchar(200) DEFAULT NULL,
  `restart_cmd` varchar(200) DEFAULT NULL,
  `run_dir` varchar(200) DEFAULT NULL,
  `run_state` varchar(200) DEFAULT NULL,
  `time_state` varchar(200) DEFAULT NULL,
  `type` varchar(200) DEFAULT NULL,
  `user` varchar(200) DEFAULT NULL,
  `pid` int(11) NOT NULL,
  KEY(id),
  PRIMARY KEY (`province`,`ip`,`pid`,`main`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `topic_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(200) DEFAULT NULL,
  `ip` varchar(64) NOT NULL,
  `user` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `province` varchar(128) NOT NULL,
  `cmd` varchar(200) DEFAULT NULL,
  `state` varchar(200) DEFAULT NULL,
  `refresh_time` varchar(200) DEFAULT NULL,
  `realtime_data` varchar(200) DEFAULT NULL,
  `total_data` varchar(200) DEFAULT NULL,
  `topic_log` varchar(200) DEFAULT NULL,
   KEY(id),
  PRIMARY KEY (`topic_name`,`ip`,`province`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;