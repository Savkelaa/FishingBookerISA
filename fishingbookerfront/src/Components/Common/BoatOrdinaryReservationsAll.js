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


export default function CottageReservationHistory({
  finishedReservations,
}) {
  console.log("finishedReservations", finishedReservations);
  const timeElapsed = Date.now();
  const today = new Date(timeElapsed);
  const [mappedFinishedReservations, setMappedFinishedReservations] = useState(finishedReservations);
  const [logedClient, setLogedClient] = useState(JSON.parse(localStorage.getItem("Client")))
  //  const date = new Date("2022-05-19");
  useEffect(() => {
    boatQuickReservationServices
    .getAllBoatReservationsByClient2(logedClient.id)
      .then((data) => {
        setMappedFinishedReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);


  function SortPriceASC(){
    const numAscending = [...mappedFinishedReservations].sort((a, b) => a.price - b.price);
    setMappedFinishedReservations(numAscending)
  }
  function SortPriceDESC(){
    const numAscending = [...mappedFinishedReservations].sort((a, b) => b.price - a.price);
    setMappedFinishedReservations(numAscending)
  }
  function SortLengthASC(){
    const numAscending = [...mappedFinishedReservations].sort((a, b) => a.length - b.length);
    setMappedFinishedReservations(numAscending)
  }
  function SortLengthDESC(){
    const numAscending = [...mappedFinishedReservations].sort((a, b) => b.length - a.length);
    setMappedFinishedReservations(numAscending)
  }
  function SortDateASC(){
    const numAscending = [...mappedFinishedReservations].sort((a, b) => a.startDate > b.startDate ? 1 : -1);
    setMappedFinishedReservations(numAscending)
  }
  function SortDateDESC(){
    const numAscending = [...mappedFinishedReservations].sort((a, b) => a.startDate < b.startDate ? 1 : -1);
    setMappedFinishedReservations(numAscending)
  }

  return (
    <div>
      <div className="App">
        <div className="header">
          <h1 style={{ textAlign: "center" }}> All reservations </h1>
        </div>
        <Button onClick={()=>{
        SortPriceASC()
       
      }}>Sort PriceASC</Button>
            <Button onClick={()=>{
        SortPriceDESC()
       
      }}>Sort PriceDESC</Button>
            <Button onClick={()=>{
        SortDateASC()
       
      }}>Sort DateASC</Button>
       <Button onClick={()=>{
        SortDateDESC()
       
      }}>Sort DateDESC</Button>
        {mappedFinishedReservations?.map((reservation) => (
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
                        <Card.Text>Price: {reservation.price} euro</Card.Text>
                        <Card.Text> Address: {reservation.boat.address}</Card.Text>

                        <Card.Text>
                          Start date: {reservation.startDate}
                        </Card.Text>
                        <Card.Text>
                          End date: {reservation.finishDate}
                        </Card.Text>
                        <Card.Text>
                          Owner: {reservation.boat.id}
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
