# Typetalk for Confluence

[![Build Status](https://travis-ci.org/14kw/typetalk-for-confluence.svg?branch=master)](https://travis-ci.org/14kw/typetalk-for-confluence)
[![Job Status](https://inspecode.rocro.com/badges/github.com/14kw/typetalk-for-confluence/status?token=N4M6KVnmknU0E6SZFR3OMYLlEbKNfCTlGQWfj7D9Fqo)](https://inspecode.rocro.com/jobs/github.com/14kw/typetalk-for-confluence/latest?completed=true)

![typetalk-for-confluence-demo](typetalk-for-confluence.mov.gif)

## Install

Build with `atlas compile && atlas-package` and install by clicking "Upload add-on" in the "Manage add-ons" section in Confluence Administration.

## Configure

Configure notification webhookUrl(post message URL) in the Space Administration Add-on.

ex: https://typetalk.com/api/v1/topics/00000?typetalkToken=xxxxxx

## Notification Action

* Create page/blog
* Updata page/blog (notice watcher)