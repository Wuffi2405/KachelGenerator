import xml.etree.ElementTree as ET
import uuid


class Element:

    def __init__(self, pointer):
        self.pointer = pointer

        attributes = pointer.attrib

        # TODO check if missing
        # XXX dafgadfg
        # BUG agfgadgadfg
        # HACK gfagdfgadfgdf
        # FIXME fdsaafsdgafdg
        # [ ] dsfasfasdf
        # [x] gfdagdfgdfg

        self.id = [attributes[x] for x in attributes if x.startswith(
            "{http://www.spd-bautzen.de/kg}id")][0]
        self.type = [attributes[x] for x in attributes if x.startswith(
            "{http://www.spd-bautzen.de/kg}type")][0]
        self.value = pointer.text
