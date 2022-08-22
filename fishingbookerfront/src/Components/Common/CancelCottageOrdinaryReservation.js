import React, { useState, useEffect } from "react";
import cottageQuickReservationServices from "../../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import Popup from "./Popup";

export default function CottageReservationHistory({
  finishedReservations,
}) {
  console.log("finishedReservations", finishedReservations);
  const timeElapsed = Date.now();
  const today = new Date(timeElapsed);

  //  const date = new Date("2022-05-19");

  var currReservations = [];

  finishedReservations.forEach((reservation) => {
    const startDate = new Date(reservation.startDate);
    const endDate = new Date(reservation.finishDate);
    if(startDate>today)
    currReservations.push(reservation);

  });

  console.log("finishedReservationssssss", currReservations);

  return (
    <div>
      <div className="App">
        <div className="header">
          <h1 style={{ textAlign: "center" }}> Future Reservation </h1>
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
                          Cottage: {reservation.cottage.name}
                        </Card.Title>

                      
                        <Card.Text>
                          Description:{" "}
                          {reservation.cottage.promoDescription}
                        </Card.Text>
                        <Card.Text>Price: {reservation.cottage.price} euro</Card.Text>
                        <Card.Text> Address: {reservation.cottage.address}</Card.Text>

                        <Card.Text>
                          Start date: {reservation.startDate}
                        </Card.Text>
                        <Card.Text>
                          End date: {reservation.finishDate}
                        </Card.Text>
                        <Card.Text>
                          Owner: {reservation.cottage.id}
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
                                    cottageQuickReservationServices.DELCottageOrdinaryReservation(reservation.id);
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
