import sqlite3
def expo():
    db=sqlite3.connect("pk.db")
    cursor=db.cursor()
    sentense="SELECT * FROM pkdata "

    html = open('Pkexpo.html', 'w')

    html.write('<html>')

    html.write('<head>')
    html.write('	<title>Exportacion de pokemones</title>')
    html.write('	<style>')
    html.write('	body{')
    html.write('		background: url(https://images8.alphacoders.com/548/thumb-1920-548142.jpg) #cccccc;')
    html.write('		background-size: 100%')
    html.write('	}')
    html.write('	table{')
    html.write('		background: white;')
    html.write('		width: 400px;')
    html.write('		margin-top: 100px;')
    html.write('	}')
    html.write('	</style>')
    html.write('</head>')
    html.write('<body>')
    html.write('	<center>')
    if (cursor.execute(sentense)):
        rows=cursor.fetchall()
        for row in rows:
            html.write('		<table border="15">')
            html.write('			<tr>')
            html.write('				<td>Nombre:</td>')
            html.write('				<td>'+row[0]+'</td>')

            html.write('			</tr>')
            html.write('			<tr>')
            html.write('				<td>Tipo:</td>')
            html.write('				<td>'+row[1]+'</td>')

            html.write('			</tr>')
            html.write('			<tr>')
            html.write('			<td>Signo del Zodiaco:</td>')
            html.write('			<td>'+row[2]+'</td>')

            html.write('			</tr>')

            html.write('			<tr>')
            html.write('				<td>Tipo de sangre:</td>')
            html.write('				<td>'+row[3]+'</td>')
            html.write('			</tr>')

            html.write('			<tr>')
            html.write('				<td>fecha de nacimiento:</td>')
            html.write('				<td>'+row[4]+'</td>')
            html.write('			</tr>')

            html.write('			<tr>')
            html.write('				<td>Comida:</td>')
            html.write('				<td>'+row[5]+'</td>')
            html.write('			</tr>')

            html.write('			<tr>')
            html.write('				<td>Latitud:</td>')
            html.write('				<td>'+(str(row[6]))+'</td>')
            html.write('			</tr>')

            html.write('			<tr>')
            html.write('				<td>Longitud:</td>')
            html.write('				<td>'+(str(row[7]))+'</td>')
            html.write('			</tr>')

            html.write('		</table>')

		

    html.write('	</center>')
        




    html.write('</body>')
    html.write('</html>')

    html.close()
