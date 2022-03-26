import xml.etree.ElementTree as ET


class Editing:

    def __init__(self, srcfile):
        self.rsrcl = srcfile
        self.tree = ET.parse(srcfile)
        self.root = self.tree.getroot()

    def loadElements(self):

        print("[KG] loading Elements")

        elementList = []

        todoList = [self.root]
        while(len(todoList)):
            nextList = []
            for element in todoList:
                attributes = element.attrib
                if "{http://www.spd-bautzen.de/kg}type" in attributes:
                    print("found", element, attributes)
                    elementList.append(element)

                for child in element:
                    nextList.append(child)
            todoList = nextList

        return elementList

    def update(self, id, image, value):

        print("[KG] updating sharepic")

        todoList = [self.root]
        while(len(todoList)):
            nextList = []
            for element in todoList:
                attributes = element.attrib
                if "{http://www.spd-bautzen.de/kg}id" in attributes:
                    if attributes['{http://www.spd-bautzen.de/kg}id'] == id:
                        element.text = value
                        todoList = []
                        break

                for child in element:
                    nextList.append(child)
            todoList = nextList

        self.tree.write('static/' + image + '.svg')
