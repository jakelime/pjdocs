.. java:import:: java.io BufferedReader

.. java:import:: java.io FileReader

.. java:import:: java.io IOException

JFileReader
===========

.. java:package:: phdf_j
   :noindex:

.. java:type:: public class JFileReader

Fields
------
filepath
^^^^^^^^

.. java:field:: public String filepath
   :outertype: JFileReader

Constructors
------------
JFileReader
^^^^^^^^^^^

.. java:constructor:: public JFileReader(String input_filepath)
   :outertype: JFileReader

   This is class Reader object to parse JSON files The parsed string will be passed to python wrapper to make HDF data container

   :param input_filepath: Absolute filepath of the JSON file
   :return: null

Methods
-------
read
^^^^

.. java:method:: public String read()
   :outertype: JFileReader

   Basic function to read content of the JSON file

   :return: String

