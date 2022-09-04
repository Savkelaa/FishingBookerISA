import React, { useState, useEffect } from "react";
import boatQuickReservationServices from "../../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import Popup from "./Popup";

export default function BoatCurrentReservations({
  currentReservations,
}) {
  console.log("currentReservations", currentReservations);
  const timeElapsed = Date.now();
  const today = new Date(timeElapsed);

  //  const date = new Date("2022-05-19");

  var currReservations = [];

  currentReservations.forEach((reservation) => {
    const startDate = new Date(reservation.startDate);
    const endDate = new Date(reservation.finishDate);
    if(startDate>today)
    currReservations.push(reservation);

  });

  console.log("currentReservationssssss", currReservations);

  return (
    <div>
      <div className="App">
        <div className="header">
          <h1 style={{ textAlign: "center" }}> Future Reservations </h1>
        </div>
        {currReservations.map((reservation) => (
          <div className="container">
            <div className="row gutters">
              <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div className="card h-100">
                  <div className="card-body">
                    <Card className="cardContainer" style={{ width: "30rem" }}>
                      <Card.Img variant="top" />
                      <Card.Body>
                        <Card.Title className="cardTitle">
                          Boat: {reservation.boat.name}
                        </Card.Title>
                        <Card.Text>
                          Description:{" "}
                          {reservation.boat.promoDescription}
                        </Card.Text>
                        <Card.Text>Price: {reservation.boat.price} euro</Card.Text>
                        <Card.Text> Address: {reservation.boat.address}</Card.Text>

                        <Card.Text>
                          Start date: {reservation.startDate}
                        </Card.Text>
                        <Card.Text>
                          End date: {reservation.finishDate}
                        </Card.Text>
                      </Card.Body>
                      <Link
                        reservation={reservation}
                        to={`/clientHomePage`}
                      >
                        <Card.Body>
                          <Button
                            onClick={() =>{
                                var toString=reservation.startDate.toString();
                                var date=new Date(toString)
                                if((date.getTime()-today.getTime())/(1000 * 3600 * 24)>3){
                                    boatQuickReservationServices.deleteBoatQuickReservation(reservation.id)
                                    alert("SUCCESFULY CANCEL RESERVATION")
                                }else{
                                    alert("CANT CANCEL NOW");
                                    
                                }
                                
                            }
                                
                            }
                          >
                            Cancel reservation
                          </Button>
                        </Card.Body>
                      </Link>
                      
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
