
     function getTasks() {
         const promise = axios.get(`http://localhost:8080/bookmark/api/todo`);
         return promise.then((response) => {
         return response.data;
             });
         }
            
 
        
    function sendMessage(data) {
	 
		const promise = axios.post(`http://localhost:8080/bookmark/api/todo/add`,
		{
       		message: data.message
			

	    },
		{
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(response => {
			console.log(response);
		}).catch(err => {
			console.log(err, err.response);
		});
		return promise.then((response) => {
			return response.data;
		});
	
	

	}