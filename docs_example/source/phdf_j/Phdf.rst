.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: javax.swing.filechooser FileSystemView

Phdf
====

.. java:package:: phdf_j
   :noindex:

.. java:type:: public class Phdf

Constructors
------------
Phdf
^^^^

.. java:constructor:: public Phdf()
   :outertype: Phdf

   HDF object manager to handle get_json, find_python, run_python

   Obective is to pass JSON to python to create HDF file container

Methods
-------
appendCommand
^^^^^^^^^^^^^

.. java:method:: public void appendCommand(String cmdSnippet)
   :outertype: Phdf

appendUserInputToCommand
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void appendUserInputToCommand(String inputString, String inputDir)
   :outertype: Phdf

getCliPath
^^^^^^^^^^

.. java:method:: public String getCliPath()
   :outertype: Phdf

getCommand
^^^^^^^^^^

.. java:method:: public String getCommand()
   :outertype: Phdf

getDataString
^^^^^^^^^^^^^

.. java:method:: public String getDataString()
   :outertype: Phdf

getMyDocPath
^^^^^^^^^^^^

.. java:method:: public String getMyDocPath()
   :outertype: Phdf

getPythonPath
^^^^^^^^^^^^^

.. java:method:: public String getPythonPath()
   :outertype: Phdf

getTargetDir
^^^^^^^^^^^^

.. java:method:: public String getTargetDir()
   :outertype: Phdf

initCommand
^^^^^^^^^^^

.. java:method:: public void initCommand()
   :outertype: Phdf

run
^^^

.. java:method:: public int run(String dataString, String targetDir)
   :outertype: Phdf

   Sends a commond to OS using ProcessBuilder, to run python cli app on the JSON

   :param dataString: The JSON content in
   :param targetDir: Parent directory of where the output file should be
   :return: int

setCliPath
^^^^^^^^^^

.. java:method:: public void setCliPath(String cliPath)
   :outertype: Phdf

setCommand
^^^^^^^^^^

.. java:method:: public void setCommand(List<String> command)
   :outertype: Phdf

setDataString
^^^^^^^^^^^^^

.. java:method:: public void setDataString(String dataString)
   :outertype: Phdf

setMyDocPath
^^^^^^^^^^^^

.. java:method:: public void setMyDocPath(String myDocPath)
   :outertype: Phdf

setPythonPath
^^^^^^^^^^^^^

.. java:method:: public void setPythonPath(String inputPythonPath)
   :outertype: Phdf

setTargetDir
^^^^^^^^^^^^

.. java:method:: public void setTargetDir(String targetDir)
   :outertype: Phdf

