<?php 

session_start();


$_SESSION["userName"] = $_GET["userName"];


header("Location: Listes.php");

?>