import sqlite3
def birth():
    db=sqlite3.connect("pk.db")
    cursor=db.cursor()
    sentense="SELECT * FROM pkdata "

    if (cursor.execute(sentense)):
        rows=cursor.fetchall()
        print("+{:-<20}+{:-<20}+".format("",""))
        print("|{:^20}|{:^20}|".format("Nombre","Fecha Nacimiento"))
        print("+{:-<20}+{:-<20}+".format("",""))
        for row in rows:
            print("|{:^20}|{:^20}|".format(row[0],row[4]))
            print("+{:-<20}+{:-<20}+".format("",""))