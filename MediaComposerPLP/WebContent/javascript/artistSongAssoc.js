/**
 * 
 */
function validateSongs(x)
{
	var i=0,count=0;
	document.write(document.form.associate.value);
	if (document.form.associate.value=="Associate")
	{
	for(i=0;i<x;i++)
	{
		if(document.form.songSelect[i].checked==true)
		{
			//alert(document.form.songSelect[i].value);
			count++;
			return true;
		}
	}
	alert("Please select atleast one song.");
	return false;
	}
	else
		return false;

	
}