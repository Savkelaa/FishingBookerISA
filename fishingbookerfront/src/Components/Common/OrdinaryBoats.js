import React, { useState, useEffect } from "react";
import boatServices from "../../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import fishingClassServices from "../../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices"
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import Popup from "./Popup";

export default function CurrentReservations({ currentReservations}) {


  //  const date = new Date("2022-05-19");
  var logedClient = JSON.parse(localStorage.getItem("Client"));
  var start = JSON.parse(localStorage.getItem("StartDate"));
  var finish = JSON.parse(localStorage.getItem("FinishDate"));
  console.log(start);
  const [tags, setTags] = useState([]);
  const [cant3, setCant] = useState(JSON.parse(localStorage.getItem("cant3")))

  var currReservations = [];
  currentReservations.forEach(element =>{
    currReservations.push(element);
  });

  useEffect(() => {
    fishingClassServices
      .getAllAdditionalServiceNames()
      .then((data) => {
        setTags(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  const removeTags = (indexToRemove) => {
    setTags([...tags.filter((_, index) => index !== indexToRemove)]);
  };
  const addTags = (event) => {
    if (event.target.value !== "") {
      setTags([...tags, event.target.value]);
      //  props.selectedTags([...tags, event.target.value]);

      event.target.value = "";
    }
  };

  function forbidde(fishing) {
    fishing.date1=start
    fishing.date2=finish
    let newFishing=[]
    if(cant3!==null)
      newFishing=cant3;
  
    newFishing.push(fishing);
    setCant(newFishing)
    localStorage.setItem("cant3", JSON.stringify(newFishing));
  }
  var reservationObject ={
    startDate:start,
    finishDate:finish,
    status:"booked",
    price:0,
    client:logedClient,
    boat:null
  }
  

  return (
    <div>
      <div className="App">
        <div className="header">
          <h1 style={{ textAlign: "center" }}> Book boat </h1>
        </div>
        {currReservations?.map((reservation) => (
          <div className="container">
            <div className="row gutters">
              <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div className="card h-100">
                  <div className="card-body">
                    <Card className="cardContainer" style={{ width: "30rem" }}>
                      <Card.Img variant="top" />
                      <Card.Body>
                        <Card.Title className="cardTitle">
                          BoatName: {reservation.name}
                        </Card.Title>
                        <Card.Text>
                          Description:{" "}
                          {reservation.promoDescription}
                        </Card.Text>
                        <Card.Text>Price: {reservation.price} euro</Card.Text>
                        <Card.Text> Place: {reservation.address}</Card.Text>
                        <Button onClick={()=>{
                                reservationObject.price=reservation.price;
                                reservationObject.boat=reservation;                               
                                boatServices.createBoatReservation(reservationObject);
                                alert("Uspesno");
                                forbidde(reservation)
                                
                        }
                        }
                        >Book</Button>
                        <h6 for="website">Additional items</h6>
                <div className="tags-input">
                  <ul id="tags">
                    {tags?.map((tag, index) => (
                      <li key={index} className="tag">
                        <span className="tag-title">{tag}</span>
                        <span
                          className="tag-close-icon"
                          onClick={() => removeTags(index)}
                        >
                          x
                        </span>
                      </li>
                    ))}
                  </ul>
                  <input
                    type="text"
                    onKeyUp={(event) =>
                      event.key === "Shift" ? addTags(event) : null
                    }
                    placeholder="Press shift to add tags"
                  />
                </div>
                      </Card.Body>
                    </Card>
                  </div>
                </div>
              </div>
            </div>
          </div>
        ))}
      


      </div>
    </div>
  );
}
