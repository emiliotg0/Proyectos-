import sqlite3
import os
c=True
def atta():
    db=sqlite3.connect("pk.db")
    cursor=db.cursor()
    sentense="SELECT * FROM pkdata "
    if (cursor.execute(sentense)):
        rows=cursor.fetchall()
        f=open("map.html",'r')
        while c:
            l=f.readline()
            if l== "\t\t\t{MARCADORES}\n":
                break
        for row in rows:

            tmp= {"""L.marker(["""+(str(row[6]))+""","""+(str(row[7]))+"""])  
            .addTo(map)  
            .bindPopup('"""+(str(row[0]))+"""');"""}
            tmpstr=(str(tmp))
            base= l.replace("\t\t\t{MARCADORES}\n",tmpstr)

            f= open("map.html",'a')
            f.write(base)
            f.close()