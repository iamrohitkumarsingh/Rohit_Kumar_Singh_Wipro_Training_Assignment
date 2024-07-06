echo "Enter the file Name"
read file_name
if [ -e "$file_name" ]
then
	echo "File Exist"
else
	echo "File not Exist"
fi

