# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     22and23_e_health
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2023-03-30 17:49:29
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for 22and23_e_health
CREATE DATABASE IF NOT EXISTS `22and23_e_health` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `22and23_e_health`;


# Dumping structure for table 22and23_e_health.tblblockchain
CREATE TABLE IF NOT EXISTS `tblblockchain` (
  `TransactionID` int(10) NOT NULL AUTO_INCREMENT,
  `Hospital_Email_ID` longtext,
  `BlocKData` longtext,
  `Current_Times` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table 22and23_e_health.tblblockchain: 2 rows
/*!40000 ALTER TABLE `tblblockchain` DISABLE KEYS */;
INSERT INTO `tblblockchain` (`TransactionID`, `Hospital_Email_ID`, `BlocKData`, `Current_Times`) VALUES (1, 'tata@gmail.com', '00000ca1c6985041ab835796545128133898a7b55a5ca93e88dfd39d4387c2de', '2023-03-30 17:41:01'), (2, 'tata@gmail.com', '00000de554f9edaf875f1d63d0c026bf8acdf19f9879b12e34fb21cb5403a36d', '2023-03-30 17:44:39');
/*!40000 ALTER TABLE `tblblockchain` ENABLE KEYS */;


# Dumping structure for table 22and23_e_health.tblhospital
CREATE TABLE IF NOT EXISTS `tblhospital` (
  `ID_Patient` int(10) NOT NULL AUTO_INCREMENT,
  `Name` text,
  `Email_IDs` text,
  `Mobile_No` text,
  `Passwords` text,
  `Address` text,
  PRIMARY KEY (`ID_Patient`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table 22and23_e_health.tblhospital: 1 rows
/*!40000 ALTER TABLE `tblhospital` DISABLE KEYS */;
INSERT INTO `tblhospital` (`ID_Patient`, `Name`, `Email_IDs`, `Mobile_No`, `Passwords`, `Address`) VALUES (1, 'tata', 'tata@gmail.com', '8888888888', '123456', 'pune');
/*!40000 ALTER TABLE `tblhospital` ENABLE KEYS */;


# Dumping structure for table 22and23_e_health.tblinfohospital
CREATE TABLE IF NOT EXISTS `tblinfohospital` (
  `I_IDs` int(10) NOT NULL AUTO_INCREMENT,
  `PatientEmail` text,
  `Insurance_Company` text,
  `Policy_Name` text,
  `Months` text,
  `Coverage_Msg` text,
  `Hospital_Email_ID` text,
  KEY `I_IDs` (`I_IDs`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table 22and23_e_health.tblinfohospital: 2 rows
/*!40000 ALTER TABLE `tblinfohospital` DISABLE KEYS */;
INSERT INTO `tblinfohospital` (`I_IDs`, `PatientEmail`, `Insurance_Company`, `Policy_Name`, `Months`, `Coverage_Msg`, `Hospital_Email_ID`) VALUES (1, 'abc@gmail.com', 'bajaj', 'xyz', '1', '4 member', 'tata@gmail.com'), (2, 'abc@gmail.com', 'bajaj', 'xyz', '1', '4 member', 'tata@gmail.com');
/*!40000 ALTER TABLE `tblinfohospital` ENABLE KEYS */;


# Dumping structure for table 22and23_e_health.tblinfoinsurance
CREATE TABLE IF NOT EXISTS `tblinfoinsurance` (
  `T_ID` int(10) NOT NULL AUTO_INCREMENT,
  `PatientName` text,
  `PatientEmail` text,
  `Company_Name` text,
  `Mobile_Number` text,
  `Web_Site` text,
  `Address` text,
  `Policy_No` text,
  `Policy_Name` text,
  `Policy_Tenue` text,
  `Base_Premium` text,
  `Coverage_Info` text,
  `Policy_Amount` text,
  `Email_IDs` text,
  PRIMARY KEY (`T_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table 22and23_e_health.tblinfoinsurance: 1 rows
/*!40000 ALTER TABLE `tblinfoinsurance` DISABLE KEYS */;
INSERT INTO `tblinfoinsurance` (`T_ID`, `PatientName`, `PatientEmail`, `Company_Name`, `Mobile_Number`, `Web_Site`, `Address`, `Policy_No`, `Policy_Name`, `Policy_Tenue`, `Base_Premium`, `Coverage_Info`, `Policy_Amount`, `Email_IDs`) VALUES (1, 'abc', 'abc@gmail.com', 'bajaj', '8888888889', 'www.bajaj.com', 'pune', '123456789', 'xyz', '1', '9500', '4 member', '300000', 'bajaj@gmail.com');
/*!40000 ALTER TABLE `tblinfoinsurance` ENABLE KEYS */;


# Dumping structure for table 22and23_e_health.tblinsurance
CREATE TABLE IF NOT EXISTS `tblinsurance` (
  `ID_Patient` int(10) NOT NULL AUTO_INCREMENT,
  `Name` text,
  `Email_IDs` text,
  `Mobile_No` text,
  `Passwords` text,
  `Address` text,
  `Gender` text,
  PRIMARY KEY (`ID_Patient`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table 22and23_e_health.tblinsurance: 1 rows
/*!40000 ALTER TABLE `tblinsurance` DISABLE KEYS */;
INSERT INTO `tblinsurance` (`ID_Patient`, `Name`, `Email_IDs`, `Mobile_No`, `Passwords`, `Address`, `Gender`) VALUES (1, 'bajaj', 'bajaj@gmail.com', '9999999999', '123456', 'pune', NULL);
/*!40000 ALTER TABLE `tblinsurance` ENABLE KEYS */;


# Dumping structure for table 22and23_e_health.tblinsurance_details
CREATE TABLE IF NOT EXISTS `tblinsurance_details` (
  `T_ID` int(10) NOT NULL AUTO_INCREMENT,
  `Email_IDs` text,
  `Company_Name` text,
  `Mobile_Number` text,
  `Web_Site` text,
  `Address` text,
  `Policy_No` text,
  `Policy_Name` text,
  `Policy_Tenue` text,
  `Base_Premium` text,
  `Coverage_Info` text,
  `Policy_Amount` text,
  PRIMARY KEY (`T_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table 22and23_e_health.tblinsurance_details: 1 rows
/*!40000 ALTER TABLE `tblinsurance_details` DISABLE KEYS */;
INSERT INTO `tblinsurance_details` (`T_ID`, `Email_IDs`, `Company_Name`, `Mobile_Number`, `Web_Site`, `Address`, `Policy_No`, `Policy_Name`, `Policy_Tenue`, `Base_Premium`, `Coverage_Info`, `Policy_Amount`) VALUES (1, 'bajaj@gmail.com', 'bajaj', '8888888889', 'www.bajaj.com', 'pune', '123456789', 'xyz', '1', '9500', '4 member', '300000');
/*!40000 ALTER TABLE `tblinsurance_details` ENABLE KEYS */;


# Dumping structure for table 22and23_e_health.tblmaster
CREATE TABLE IF NOT EXISTS `tblmaster` (
  `Trans_ID` int(10) NOT NULL AUTO_INCREMENT,
  `Transcation_Hash` text,
  `FromName` text,
  `ToName` text,
  `NonceData` text,
  `PreViewHash` text,
  `DiseaseFirst` text,
  `DiseaseSecond` text,
  `DiseaseThrees` text,
  `DiseaseFour` text,
  `DiseaseFive` text,
  `DiseaseSix` text,
  PRIMARY KEY (`Trans_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table 22and23_e_health.tblmaster: 2 rows
/*!40000 ALTER TABLE `tblmaster` DISABLE KEYS */;
INSERT INTO `tblmaster` (`Trans_ID`, `Transcation_Hash`, `FromName`, `ToName`, `NonceData`, `PreViewHash`, `DiseaseFirst`, `DiseaseSecond`, `DiseaseThrees`, `DiseaseFour`, `DiseaseFive`, `DiseaseSix`) VALUES (1, '00000ca1c6985041ab835796545128133898a7b55a5ca93e88dfd39d4387c2de', 'tata@gmail.com', 'abc@gmail.com', '2273260', '0000073ae627698c74747199b71adada4de84b6d9024548a82fcebddcfe8cfc7', 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg=='), (2, '00000de554f9edaf875f1d63d0c026bf8acdf19f9879b12e34fb21cb5403a36d', 'tata@gmail.com', 'abc@gmail.com', '1798967', '00000ca1c6985041ab835796545128133898a7b55a5ca93e88dfd39d4387c2de', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'rPK0NrVvTcVRO/Iq8Dd2lw==');
/*!40000 ALTER TABLE `tblmaster` ENABLE KEYS */;


# Dumping structure for table 22and23_e_health.tblmasterpatient
CREATE TABLE IF NOT EXISTS `tblmasterpatient` (
  `P_ID` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` text,
  `Middle_Name` text,
  `Last_Name` text,
  `Birth_Of_Date` text,
  `Email_ID` text,
  PRIMARY KEY (`P_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table 22and23_e_health.tblmasterpatient: 1 rows
/*!40000 ALTER TABLE `tblmasterpatient` DISABLE KEYS */;
INSERT INTO `tblmasterpatient` (`P_ID`, `First_Name`, `Middle_Name`, `Last_Name`, `Birth_Of_Date`, `Email_ID`) VALUES (1, 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg==', '1999/1/1', 'abc@gmail.com');
/*!40000 ALTER TABLE `tblmasterpatient` ENABLE KEYS */;


# Dumping structure for table 22and23_e_health.tblmasterpatientnew
CREATE TABLE IF NOT EXISTS `tblmasterpatientnew` (
  `P_ID` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` text,
  `Middle_Name` text,
  `Last_Name` text,
  `Birth_Of_Date` text,
  `DiseaseFirst` text,
  `DiseaseSecond` text,
  `DiseaseThrees` text,
  `DiseaseFour` text,
  `DiseaseFive` text,
  `DiseaseSix` text,
  `Email_ID` text,
  `DateShow` text,
  PRIMARY KEY (`P_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table 22and23_e_health.tblmasterpatientnew: 2 rows
/*!40000 ALTER TABLE `tblmasterpatientnew` DISABLE KEYS */;
INSERT INTO `tblmasterpatientnew` (`P_ID`, `First_Name`, `Middle_Name`, `Last_Name`, `Birth_Of_Date`, `DiseaseFirst`, `DiseaseSecond`, `DiseaseThrees`, `DiseaseFour`, `DiseaseFive`, `DiseaseSix`, `Email_ID`, `DateShow`) VALUES (1, 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg==', '1999/1/1', 'abc', 'xyz', '-', '-', '-', '-', 'abc@gmail.com', '2023-03-30 17:41:01'), (2, 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg==', 'Ww0w5itd5fivf5wHBONqWg==', '1999/1/1', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'rPK0NrVvTcVRO/Iq8Dd2lw==', 'abc@gmail.com', '2023-03-30 17:44:39');
/*!40000 ALTER TABLE `tblmasterpatientnew` ENABLE KEYS */;


# Dumping structure for table 22and23_e_health.tblregister
CREATE TABLE IF NOT EXISTS `tblregister` (
  `ID_Patient` int(10) NOT NULL AUTO_INCREMENT,
  `Name` text,
  `Email_IDs` text,
  `Mobile_No` text,
  `Passwords` text,
  `Address` text,
  `Gender` text,
  `Hospital_Name` text,
  PRIMARY KEY (`ID_Patient`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table 22and23_e_health.tblregister: 1 rows
/*!40000 ALTER TABLE `tblregister` DISABLE KEYS */;
INSERT INTO `tblregister` (`ID_Patient`, `Name`, `Email_IDs`, `Mobile_No`, `Passwords`, `Address`, `Gender`, `Hospital_Name`) VALUES (1, 'abc', 'abc@gmail.com', '7777777777', '123456', '7777777777', 'Male', 'tata@gmail.com');
/*!40000 ALTER TABLE `tblregister` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
