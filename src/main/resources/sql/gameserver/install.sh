#!/bin/sh

if [ -f ./mysql_settings.sh ]; then
        . ./mysql_settings.sh
else
        echo "Can't find mysql_settings.sh file!"
        exit
fi

for sqlfile in install/*.sql
do
        echo Loading "$sqlfile" to " l2_main " ...
        mysql --host="localhost" --user="root" --password="1234" "l2_main" < "$sqlfile"
done
