#!/bin/bash
echo "Enter a number:"
read num
remainder=$((num % 2))
if [ $remainder -eq 0 ]
then
echo "The number is Even"
else
echo "The number is Odd"
fi
