import os
import uuid
import shutil

class FileManager:

    def __init__(self):
        self.path_svg_template = os.getcwd() +  "/static/svg templates/"
        self.path_temp_root = os.getcwd() + "/static/temp/"

    def getTempFolders(self):
        return [folder for folder in os.listdir(self.path_temp_root) if os.path.isdir(os.path.join(self.path_temp_root, folder))]

    def allocateTemplate(self, templateID):

        if len(self.getTempFolders()) >= 20:
            raise Exception("temp folder full")

        uuidString = str(uuid.uuid4().hex)
        path = os.path.join(self.path_temp_root, uuidString)
        os.mkdir(path)
        templateFiles = [f for f in os.listdir(self.path_svg_template) if os.path.isfile(os.path.join(self.path_svg_template, f))]
        templateName = templateFiles[templateID % len(templateFiles)]
        print("CREATED NEW WORKSPACE FOLDER FOR TEMPLATE", templateName, "in folder", uuidString)
        shutil.copy2(os.path.join(self.path_svg_template, templateName), self.path_temp_root + uuidString + "/tempimg.svg")
        return uuidString