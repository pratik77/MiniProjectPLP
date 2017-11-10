/**
 * 
 */
function validateSongs(x)
{
	var i=0,count=0;
	for(i=0;i<4;i++)
	{
		if(document.form.songSelect[i].checked==true)
		{
			count++;
			return true;
		}
	}
	alert("Please select atleast one song.");
	return false;

	
}