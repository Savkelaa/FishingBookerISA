import React, { useState, useEffect } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import Popup from "./Popup";

export default function CottageUpcomingReservations({
  upcomingReservations,
  upcomingOrdReservations,
}) {
  console.log("upcomingReservations", upcomingReservations);
  console.log("upcomingOrdReservations", upcomingOrdReservations);
  const timeElapsed = Date.now();
  const today = new Date(timeElapsed);

  //  const date = new Date("2022-05-19");

  var currReservations = [];
  var currOrdReservations = [];

  upcomingReservations.forEach((reservation) => {
    const startDate = new Date(reservation.startDate);
    const endDate = new Date(reservation.finishDate);
    if (today < startDate) {
      console.log("✅ Reservation is upcoming.");
      currReservations.push(reservation);
    } else {
      console.log("⛔️ date is not in the range");
      console.log("reservation.startDate", startDate);
      console.log("reservation.endDate", endDate);
    }
  });

  console.log("upcomingReservationssssss", currReservations);

  upcomingOrdReservations.forEach((reservation) => {
    const startDate = new Date(reservation.startDate);
    const endDate = new Date(reservation.finishDate);
    if (today < startDate) {
      console.log("✅ Reservation is upcoming.");
      currReservations.push(reservation);
    } else {
      console.log("⛔️ date is not in the range");
      console.log("reservation.startDate", startDate);
      console.log("reservation.endDate", endDate);
    }
  });

  console.log("upcomingOrdReservationssssss", currOrdReservations);

  return (
    <div>
      <div className="App">
        <div className="header">
          <h1 style={{ textAlign: "center" }}> Upcoming Reservations </h1>
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
                        <Card.Text>Price: {reservation.price} euro</Card.Text>
                        <Card.Text> Address: {reservation.cottage.address}</Card.Text>

                        <Card.Text>
                          Start date: {reservation.startDate}
                        </Card.Text>
                        <Card.Text>
                          End date: {reservation.finishDate}
                        </Card.Text>
                      </Card.Body>
                      <ListGroup className="list-group-flush">
                        <ListGroupItem>
                          <Card.Title className="cardTitle">
                            {reservation.client.name}{" "}
                            {reservation.client.surname}
                          </Card.Title>

                          <Card.Text>
                            {" "}
                            Email: {reservation.client.email}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Explanation of registration:{" "}
                            {reservation.client.explanation}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Address: {reservation.client.address}{" "}
                            {reservation.client.city}{" "}
                            {reservation.client.country}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Number: {reservation.client.number}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Penalty: {reservation.client.penalty}
                          </Card.Text>
                        </ListGroupItem>
                      </ListGroup>
                      
                    </Card>
                  </div>
                </div>
              </div>
            </div>
          </div>
        ))}
        
        {currOrdReservations.map((reservation) => (
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
                        <Card.Text>Price: {reservation.price} euro</Card.Text>
                        <Card.Text> Address: {reservation.cottage.address}</Card.Text>

                        <Card.Text>
                          Start date: {reservation.startDate}
                        </Card.Text>
                        <Card.Text>
                          End date: {reservation.finishDate}
                        </Card.Text>
                      </Card.Body>
                      <ListGroup className="list-group-flush">
                        <ListGroupItem>
                          <Card.Title className="cardTitle">
                            {reservation.client.name}{" "}
                            {reservation.client.surname}
                          </Card.Title>

                          <Card.Text>
                            {" "}
                            Email: {reservation.client.email}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Explanation of registration:{" "}
                            {reservation.client.explanation}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Address: {reservation.client.address}{" "}
                            {reservation.client.city}{" "}
                            {reservation.client.country}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Number: {reservation.client.number}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Penalty: {reservation.client.penalty}
                          </Card.Text>
                        </ListGroupItem>
                      </ListGroup>
                      
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
