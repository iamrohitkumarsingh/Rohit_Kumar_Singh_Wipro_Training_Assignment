set -x
directory="Deepika"
if [ -d "$directory" ]
then
	echo "Directory exists"
else
	mkdir -p "$directory"
	echo "Directory created"
fi
set +x
