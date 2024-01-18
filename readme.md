# PJdocs

Using sphinx-doc (python), run it on Java project to generate high
quality documentations.

It has an extension to work with `JavaDoc`. In the Java code, write
inline comments in JavaDoc style as usual.

## Quickstart

Normal usage, writing documentations

```bash
git clone https://github.com/jakelime/pjdocs-project.git
cd pjdocs-project
PS C:\Users\70014156\Documents\pjdocs-project> python -m venv venv
PS C:\Users\70014156\Documents\pjdocs-project> .\venv\Scripts\activate
(venv) PS C:\Users\70014156\Documents\pjdocs-project> pip install ....

(venv) PS C:\Users\70014156\Documents\pjdocs-project> sphinx-quickstart doc
(venv) PS C:\Users\70014156\Documents\pjdocs-project> sphinx-build -M html docs/source/ docs/build/
Running Sphinx v7.2.6
building [html]: targets for 1 source files that are out of date
done
build succeeded.

The HTML pages are in docs\build\html.

```

Using `autodocs` API to generate `src-*.rst` files automatically.

Step1: Update `conf.py`

```python
extensions = ["javasphinx", "sphinx_rtd_theme"]
html_theme = "sphinx_rtd_theme"
javadoc_url_map = {
    "com.netflix.curator": ("http://netflix.github.com/curator/doc", "javadoc"),
    "org.springframework": (
        "http://static.springsource.org/spring/docs/3.1.x/javadoc-api/",
        "javadoc",
    ),
    "org.springframework.data.redis": (
        "http://static.springsource.org/spring-data/data-redis/docs/current/api/",
        "javadoc",
    ),
}
```

Step2: Run `javasphinx-apidoc`. This will read the entire Java source codes and create the relevant `*.rst`

```shell
(venv) PS C:\Users\70014156\Documents\pjdocs-project> javasphinx-apidoc.exe -o c:\Users\70014156\Documents\pjdocs-project\docs\source c:\Users\70014156\Documents\pjdocs-project\phdf_j
```

Step3: Update the `index.rst` page, add another page `intro.rst`

```text
JavaPython HDF Processor documentation
====================================================

jphdf is a java wrapper over python to process semiconductor
test data into big data container HDF for efficient storage.


.. toctree::
   :maxdepth: 2
   :caption: Contents:

   intro.rst
   packages.rst

```

Step4: Compile into HTML

```shell

(venv_dj) PS C:\Users\70014156\Documents\pjdocs-project> sphinx-build -M html docs/source/ docs/build/
Running Sphinx v7.2.6
loading pickled environment... done
done

The HTML pages are in docs\build\html.
```

## Notes

1. Sphinx is a well-documented high quality project `pip install Sphinx`

1. To support Java projects, we can use [javasphinx](https://bronto-javasphinx.readthedocs.io/)

1. Howerver, the official `javasphinx` is already deprecated. We can use
   [lucag/javasphinx](https://github.com/lucag/javasphinx) to get compatibilty
   fixes to the latest `Sphinx` version
