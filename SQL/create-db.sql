create database if not exists `etiqa-assessment` character set utf8 collate utf8_bin; 
grant all privileges on `etiqa-assessment`.* to 'etiqadb'@'%' identified by 'orsvyjbmzb' with grant option;
flush privileges;