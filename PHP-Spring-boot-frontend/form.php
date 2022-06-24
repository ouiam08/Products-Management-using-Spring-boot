<?php
session_start();
if (!isset($_SESSION["userName"])) {
    header('Location: login.php');
    exit;
}
?>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Creer un Produit</title>
    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.3.1/css/all.css'>

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body><br>
    <fieldset style="width: 500px;margin:auto">
        <legend style="margin-left: 100px; color:#6ca7f3">Créer un Produit</legend>
        <form enctype="multipart/form-data" action="" method="POST">
            <pre>

            Nom : <input type="text" name="nomProduit" id="nom"/>

            Prix  <input type="text" name="prixProduit" id="prix">

           DATE DE CREATION <input type="date" name="date" id="date">

           image: <input type="file" name="image">

            <div class="form-group">
                <input type="submit" value="ajouter" class="btn" style="background-color: #6ca7f3;">
            </div>
        </pre>
        </form>
    </fieldset>
    <div>
        <?php

        $file_name = "default.jpg";

        if (isset($_FILES['image'])) {
            $file_name = $_FILES['image']['name'];
            $file_tmp = $_FILES['image']['tmp_name'];
            move_uploaded_file($file_tmp, "imgs/" . $file_name);

        ?>
            <form action="http://localhost:8080/produits/ajouterProduit" method="post">


                <input type="text" hidden name="nomProduit" id="nom" value="<?php echo $_POST['nomProduit'] ?>" />

                <input type="text" hidden name="prixProduit" id="prix" value="<?php echo $_POST['prixProduit'] ?>">

                <input type="date" hidden name="date" id="date" value="<?php echo $_POST['date'] ?>">

                <input type="text" hidden name="image" id="img" value="<?php echo $file_name ?>">

                <div class="form-group" style="margin-top: 60px;">
                    <input type="submit" value="Listes des produits" class="btn" style="background-color: green;">
                </div>

            </form>
        <?php
        }

        ?>
    </div>
    <br />

</body>

</html>