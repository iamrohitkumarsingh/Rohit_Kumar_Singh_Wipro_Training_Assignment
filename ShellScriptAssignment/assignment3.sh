count_lines_in_file(){
	local filename="$1"
	local line_count=$(wc -w < "$filename")
	echo "Number of lines in $filename : $line_count"
}
count_lines_in_file "sample1.log"
count_lines_in_file "sample2.log"

