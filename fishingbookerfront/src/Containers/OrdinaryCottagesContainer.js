import React, { useState, useEffect } from "react";
import CurrentReservations from "../Components/Common/OrdinaryCottages";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import cottageService from "../Services/CottageServices/CottageServices";


export default function CurrentReservationsContainer() {
  const [currentReservations, setCurrentReservations] = useState([]);
  const [cant, setCant] = useState(JSON.parse(localStorage.getItem("cant2")))
  var start = JSON.parse(localStorage.getItem("StartDate"));
  var finish = JSON.parse(localStorage.getItem("FinishDate"));

  useEffect(() => {
   cottageService.getAllCottages()
      .then((data) => {
        setCurrentReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));

 
  }, []);

  if(cant!==null){
    cant.forEach(element=>{
      for( let i = 0; i < currentReservations.length; i++){ 
     
        if ( currentReservations[i].id == element.id && ((element.date1>=start && element.date1<finish) || (element.date1<start && element.date2>start)) ) { 
         
            currentReservations.splice(i, 1); 
        }
    
    }
    
    })
    
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CurrentReservations
        currentReservations={currentReservations}
      ></CurrentReservations>
      <Footerr></Footerr>
    </div>
  );
}
