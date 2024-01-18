# Configuration file for the Sphinx documentation builder.
#
# For the full list of built-in configuration values, see the documentation:
# https://www.sphinx-doc.org/en/master/usage/configuration.html

# -- Project information -----------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#project-information

project = 'JavaPython HDF Processor'
copyright = '2024, Jake Lim'
author = 'Jake Lim'
release = '0.0.1'

# -- General configuration ---------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#general-configuration

# extensions = []
extensions = ["javasphinx", "sphinx_rtd_theme"]

templates_path = ['_templates']
exclude_patterns = []



# -- Options for HTML output -------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#options-for-html-output

# html_theme = 'alabaster'
html_theme = "sphinx_rtd_theme"
html_static_path = ['_static']
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