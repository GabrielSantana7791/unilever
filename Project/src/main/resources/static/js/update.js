function unMaterial (cod, unName, unTotal, unBox, box){
	const obj = document.getElementById(cod + 'unMaterial')
	
	if(box === true){
		document.getElementById(cod + 'needMaterialUn').innerHTML = (obj.value * unTotal) + " (" + unName + ")"
		document.getElementById(cod + 'needBox').value = (obj.value * unBox)
	}else{
		document.getElementById(cod + 'needMaterialUn').innerHTML = (obj.value * unTotal) + " (" + unName + ")"
		document.getElementById(cod + 'needBox').value = (obj.value * unTotal)
	}
	
}

function needBox(cod, unName, unTotal, unBox, box){
	const obj = document.getElementById(cod + 'needBox')
	const unMaterial = document.getElementById(cod + 'unMaterial')
	
	if(box === true){
							
		document.getElementById(cod + 'unMaterial').value = Math.ceil((obj.value / unBox))
		document.getElementById(cod + 'needMaterialUn').innerHTML = (unMaterial.value * unTotal) + " (" + unName + ")"
	
						
	}else {
							
		document.getElementById(cod + 'unMaterial').value = Math.ceil((obj.value / unTotal))
		document.getElementById(cod + 'needMaterialUn').innerHTML = (unMaterial.value * unTotal) + " (" + unName + ")"
						
		}
	
}	