import sqlite3
def tico():
    db=sqlite3.connect("pk.db")
    cursor=db.cursor()
    sentense="SELECT * FROM pkdata "

    if (cursor.execute(sentense)):
        rows=cursor.fetchall()
        print("+{:-<20}+{:-<20}+".format("",""))
        print("|{:^20}|{:^20}|".format("Tipo","comida"))
        print("+{:-<20}+{:-<20}+".format("",""))
        for row in rows:
            print("|{:^20}|{:^20}|".format(row[1],row[5]))
            print("+{:-<20}+{:-<20}+".format("",""))

