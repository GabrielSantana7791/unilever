function mudar(cod, unName, unTotal, needMaterialUn){
	const unMaterial = document.getElementById(cod + 'needMaterialUn')
	const materialNeed = document.getElementById(cod + 'materialNeed')
	const ownMaterial = document.getElementById(cod + 'ownMaterial')
	
	if(ownMaterial.value <= 0){
		ownMaterial.value = 0
	}else if(ownMaterial.value >= needMaterialUn){
		ownMaterial.value = needMaterialUn
	}
	
	unMaterial.innerHTML = ((needMaterialUn - ownMaterial.value) * unTotal) + " (" + unName + ")"
	materialNeed.innerHTML = (needMaterialUn - ownMaterial.value)
		
}
