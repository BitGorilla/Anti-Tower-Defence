template = open("4.txt", "r")
f = open("pretty2.xml", "w+")

f.write("<maps>\n    <map>\n        <meta>\n")
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
f.write("			<wincondition>")
f.write(template.readline().rstrip("\n"))
f.write("</wincondition>\n")
f.write("		</meta>\n")
f.write("        <tiles>\n")
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

	f.write("            <tile road=\"")
	if template[i] == "S":
		f.write("SOUTH")
		roadOK = True
	elif template[i] == "N":
		f.write("NORTH")
		roadOK = True
	elif template[i] == "W":
		f.write("WEST")
		roadOK = True
	elif template[i] == "E":
		f.write("EAST")
		roadOK = True
	else:
		f.write("BLANK")


	f.write("\" type=\"")

	if template[i+1] == "S":
		f.write("StartTile")
	elif template[i+1] == "G":
		f.write("GoalTile")
	elif template[i+1] == "b":
		f.write("BlankTile")
	elif template[i+1] == "t":
		f.write("TowerTile")
	elif template[i+1] == "k":
		f.write("SpikeTile")
	elif template[i+1] == "T":
		f.write("TREE")
	elif template[i+1] == "s":
		f.write("SlowTile")
	elif template[i+1] == "w":
		f.write("WATER")
	elif template[i+1] == "r":
		f.write("SpeedTile")
	elif template[i+1] == "f":
		f.write("FlipperTile")
	elif template[i+1] == "R":
		f.write("RegenerationTile")
	elif template[i+1] == "?":
		f.write("MisdirectionTile")
	else:
		f.write("BlankTile")

	f.write("\"/>\n")
	i += 2


f.write("        </tiles>\n")
f.write("    </map>\n")
f.write("</maps>")