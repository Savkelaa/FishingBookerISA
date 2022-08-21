import React, { useState, useEffect } from "react";
import boatServices from "../../Services/BoatQuickReservationServices/BoatQuickReservationServices";
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

  var currReservations = [];
  currentReservations.forEach(element =>{
    currReservations.push(element);
  });


  
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
          <h1 style={{ textAlign: "center" }}> Current reservations </h1>
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
                                
                        }
                        }
                        >Book</Button>
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
