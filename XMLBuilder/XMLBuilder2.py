template = open("template2.txt", "r")
f = open("map2.xml", "w+")

f.write("<maps>\n    <map>\n        <meta>\n")
f.write("            <name>")
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
f.write("        <tiles>\n")
dim = int(dim)
template = template.read();

blankTile = "-"

for i in range(len(template)):
	f.write("            <tile road=\"")
	right = False
	left = False
	up = False
	down = False
	if template[i] != blankTile:
		if i+dim+2 < len(template) and template[i+dim+2] != blankTile and template[i+dim+2] != "\n":
			up = True
		if i-dim-2 > 0			   and template[i-dim-2] != blankTile and template[i-dim-2] != "\n":
			down = True
		if i+1 < len(template)	   and template[i+1] 	 != blankTile and template[i+1] 	!= "\n":
			right = True
		if i-1 > 0 				   and template[i-1] 	 != blankTile and template[i-1] 	!= "\n":
			left = True

		if left and right and up:
			f.write("east-west-north")
		elif left and right and down:
			f.write("east-west-south")


		elif up and down and right:
			f.write("north-south-east")
		elif up and down and left:
			f.write("north-south-west")

		elif right and left:
				f.write("east-west")
		elif up and down:
				f.write("north-south")
		elif up and right:
			f.write("north-east")
		elif up and left:
			f.write("north-west")
		elif left and down:
			f.write("west-south")
		elif down and right:
			f.write("south-east")

		elif up or down:
			f.write("north-south")
		elif left or right:
			f.write("east-west")

	f.write("\" type= \"")

	if template[i] == "0":
		f.write("")
	if template[i] == "s":
		f.write("slow")
	if template[i] == "S":
		f.write("start")
	if template[i] == "G":
		f.write("goal")
	else:
		f.write("")

	f.write("\"/>\n")

f.write("        </tiles>\n")
f.write("    </map>\n")
f.write("</maps>")