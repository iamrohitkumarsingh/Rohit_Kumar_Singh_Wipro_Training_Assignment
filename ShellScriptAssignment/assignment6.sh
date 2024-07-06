grep "ERROR" sample.log | awk -F '[:]' '{print $1, $2, $3, $4}'
