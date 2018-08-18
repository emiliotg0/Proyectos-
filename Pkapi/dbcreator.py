import sqlite3
def dbcreator():
    try:
        db=sqlite3.connect('pk.db')
        cursor=db.cursor()
        tablas = [

            """
                CREATE TABLE IF NOT EXISTS pkdata(
                    nombre TEXT NOT NULL,
                    tipo REAL NOT NULL,
                    signo_zodiacal TEXT NOT NULL,
                    sangre REAL NOT NULL,
                    fecha_nacimiento REAL NOT NULL,
                    comida REAL NOT NULL, 
                    Latitud REAL NOT NULL, 
                    Longitud REAL NOT NULL
                    

                );
        """       
        ]
        for tabla in tablas:
            cursor.execute(tabla) 
    except sqlite3.OperationalError as error:
	    print("Error al abrir:", error)