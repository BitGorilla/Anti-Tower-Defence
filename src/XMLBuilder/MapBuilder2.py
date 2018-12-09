template = open("Templates/newTemplate.txt", "r")
f = open("Maps/newMap.xml", "w+")

f.write("<maps>\n	<map>\n		<meta>\n")
f.write("			<name>")
f.write(template.readline().rstrip("\n"))
f.write("</name>\n")
f.write("			<height>")
dim = template.readline().rstrip("\n")
f.write(dim)
f.write("</height>\n")
f.write("			<width>")
f.write(dim)
f.write("</width>\n")
f.write("			<startcredit>")
f.write(template.readline().rstrip("\n"))
f.write("</startcredit>\n")
f.write("		</meta>\n")
f.write("		<tiles>\n")
dim = int(dim)
template = template.read();
template.rstrip("\n")
blankTile = "-"
print("width is:",dim)
print("string length:",len(template))

i = 0
while i < len(template):
	if template[i] == "\n":
		print("----")
		i += 1
		continue

	f.write("			<tile road=\"")
	if template[i] == "S":
		f.write("SOUTH-")
		roadOK = True
	elif template[i] == "N":
		f.write("NORTH-")
		roadOK = True
	elif template[i] == "W":
		f.write("WEST-")
		roadOK = True
	elif template[i] == "E":
		f.write("EAST-")
		roadOK = True
	elif template[i] == "-":
		print("doing nothing")
	else:
		f.write("")

	if template[i+1] == "S":
		f.write("SOUTH")
		roadOK = True
	elif template[i+1] == "N":
		f.write("NORTH")
		roadOK = True
	elif template[i+1] == "W":
		f.write("WEST")
		roadOK = True
	elif template[i+1] == "E":
		f.write("EAST")
		roadOK = True
	else:
		f.write("")

	if template[i+2] == "S":
		f.write("-SOUTH")
		roadOK = True
	elif template[i+2] == "N":
		f.write("-NORTH")
		roadOK = True
	elif template[i+2] == "W":
		f.write("-WEST")
		roadOK = True
	elif template[i+2] == "E":
		f.write("-EAST")
		roadOK = True
	else:
		f.write("")


	f.write("\" type=\"")

	if template[i+3] == "S":
		f.write("StartTile")
	elif template[i+3] == "G":
		f.write("GoalTile")
	elif template[i+3] == "b":
		f.write("BlankTile")
	elif template[i+3] == "s":
		f.write("SlowTile")
	else:
		f.write("BlankTile")

	f.write("\"/>\n")
	i += 4


f.write("		</tiles>\n")
f.write("    	</map>\n")
f.write("</maps>")