import os
import uuid
import shutil

class FileManager:

    def __init__(self):
        self.path_svg_template = os.getcwd() +  "/static/"
        self.path_temp_root = os.getcwd() + "/static/temp/"

    def getTempFolders(self):
        return [folder for folder in os.listdir(self.path_temp_root) if os.path.isdir(os.path.join(self.path_temp_root, folder))]

    def allocateTemplate(self, templateName):

        if len(self.getTempFolders()) >= 20:
            raise Exception("temp folder full")

        uuidString = str(uuid.uuid4().hex)
        path = os.path.join(self.path_temp_root, uuidString)
        os.mkdir(path)

        if templateName in [file for file in os.listdir(self.path_svg_template) if os.path.isfile(os.path.join(self.path_svg_template, file))]:
            print("CREATED NEW WORKSPACE FOLDER FOR TEMPLATE", templateName, "in folder", uuidString)
            shutil.copy2(os.path.join(self.path_svg_template, templateName), self.path_temp_root + uuidString + '/' + templateName)
            return uuidString
        else:
            raise Exception("template does not exist")