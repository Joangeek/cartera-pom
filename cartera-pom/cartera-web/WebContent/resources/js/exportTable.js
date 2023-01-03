function generateexcel(tableid) {
      var table= document.getElementById(tableid);
      var html = table.outerHTML;
      while (html.indexOf('á') != -1) html = html.replace('á', '&aacute;');
      while (html.indexOf('Á') != -1) html = html.replace('Á', '&Aacute;');
      while (html.indexOf('é') != -1) html = html.replace('é', '&eacute;');
      while (html.indexOf('É') != -1) html = html.replace('É', '&Eacute;');
      while (html.indexOf('í') != -1) html = html.replace('í', '&iacute;');
      while (html.indexOf('Í') != -1) html = html.replace('Í', '&Iacute;');
      while (html.indexOf('ó') != -1) html = html.replace('ó', '&oacute;');
      while (html.indexOf('Ó') != -1) html = html.replace('Ó', '&Oacute;');
      while (html.indexOf('ú') != -1) html = html.replace('ú', '&uacute;');
      while (html.indexOf('Ú') != -1) html = html.replace('Ú', '&Uacute;');
      while (html.indexOf('º') != -1) html = html.replace('º', '&ordm;');
      while (html.indexOf('ñ') != -1) html = html.replace('ñ', '&ntilde;'); 
      while (html.indexOf('Ñ') != -1) html = html.replace('Ñ', '&Ntilde;');  

  window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
}
