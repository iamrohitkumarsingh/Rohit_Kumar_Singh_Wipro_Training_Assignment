mkdir -p TestDir
for ((i=1; i<=10; i++)); do
	filename="File$i.txt"
	echo "$filename" > "TestDir/$filename"
done
echo "Files created successfully in TestDir"
