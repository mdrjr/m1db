git add *
echo "texto do commit"
read textoCommit
git commit -m "$textoCommit"
git push -u origin master
