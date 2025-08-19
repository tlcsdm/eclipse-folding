# Folding

This plugin enhances code folding in Eclipse IDE, based on and maintained from Coffee-Bytes Code Folding.  
It allows defining custom foldable regions in Java, XML, and other files using //[start] … //[end] comments, making code more organized and easier to navigate.

Fork of the coffee-bytes code folding plugin. Original source: https://code.google.com/archive/p/coffee-bytes/

## Features
- Folding support for <em>classes, methods, field groups, imports, comments, and documentation</em>.
- Custom Region Folding: Define your own folding markers (default [start] / [end]).
- Deep integration with Eclipse JDT folding preferences to enable/disable folding for specific elements.
- Customizable folding strategies in Preferences: Configure in Window → Preferences → Java → Editor → Folding.
- Preserves Native Folding: Extends Eclipse’s folding system without removing built-in features.

## Use
1. Preferences 
Click Window → Preferences → Java → Editor → Folding  
![screenshot](https://raw.github.com/tlcsdm/eclipse-folding/master/plugins/com.tlcsdm.eclipse.folding/help/images/pref.png)

## Build

This project uses [Tycho](https://github.com/eclipse-tycho/tycho) with [Maven](https://maven.apache.org/) to build. It requires Maven 3.9.0 or higher version.

Dev build:

```
mvn clean verify
```

Release build:

```
mvn clean org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=2.0.0 verify
```

## Install

1. Add `https://raw.githubusercontent.com/tlcsdm/eclipse-folding/master/update_site/` as the upgrade location in Eclipse.
2. Download from [Jenkins](https://jenkins.tlcsdm.com/job/eclipse-plugin/job/eclipse-folding)
3. <table style="border: none;">
  <tbody>
    <tr style="border:none;">
      <td style="vertical-align: middle; padding-top: 10px; border: none;">
        <a href='http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=6999684' title='Drag and drop into a running Eclipse Indigo workspace to install eclipse-folding'> 
          <img src='https://marketplace.eclipse.org/modules/custom/eclipsefdn/eclipsefdn_marketplace/images/btn-install.svg'/>
        </a>
      </td>
      <td style="vertical-align: middle; text-align: left; border: none;">
        ← Drag it to your eclipse workbench to install! (I recommand Main Toolbar as Drop Target)
      </td>
    </tr>
  </tbody>
</table>

