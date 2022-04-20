const unType = document.getElementById('unType')	
const multiple = document.getElementById('multiple')	
const unPerBox = document.getElementById('unPerBox')
const box = document.getElementById('box')
	
	var weightDiv = document.getElementById('weightToProduceOne')
	weightDiv.disabled = true;
	unPerBox.disabled = true
	
		function unTypeF(){
			
			
			if(unType.value === 'kg'){
				weightDiv.disabled = false;
				multiple.disabled = true;
			}else {
				weightDiv.disabled = true;
				multiple.disabled = false;
			}
		}
		
			function boxChange(){
				if(box.checked === false){
					unPerBox.disabled = true
				}else{
					unPerBox.disabled = false
				}

		}
		