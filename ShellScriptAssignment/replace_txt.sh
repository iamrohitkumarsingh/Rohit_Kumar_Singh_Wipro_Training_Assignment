if [ "$#" -ne 3 ]; then
	echo " Usage: $0 input_file old_text new_text"
	exit 1
fi
input_file="$1"
old_text="$2"
new_text="$3"
output_file="${input_file%.txt}_modified.txt"
if [ ! -f "$input_file" ]; then
	echo "Error: Input file '$input_file' not found"
	exit 1
fi
sed "s/$old_text/$new_text/g" "$input_file" > "$output_file"
echo "Replacement completed result saved to '$output_file'."
