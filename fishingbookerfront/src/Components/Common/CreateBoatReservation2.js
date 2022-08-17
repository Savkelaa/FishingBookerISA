import React, { useRef } from "react";
import { Redirect, useHistory } from "react-router-dom";
import { useParams } from "react-router-dom";
import boatQuickReservationServices from "../../Services/BoatQuickReservationServices/BoatQuickReservationServices";

export default function CreateBoatReservation({
  createBoatReservationHandler,
}) {
  const startDate = useRef();
  const finishDate = useRef();
  const place = useRef();
  const price = useRef();
  let { id } = useParams();

  var logedClient = JSON.parse(localStorage.getItem("Client"));

  const reservation = JSON.parse(localStorage.getItem("reservation"));
  console.log("reservation", reservation);

  function saveHandler(e) {
    createBoatReservationHandler({
      startDate: reservation.startDate,
      finishDate: reservation.finishDate,
      price: reservation.price,
      status: "booked",
      client: logedClient, /* {
        id: logedClient.id,
      }, */
      boat: { id: id },
    });
    reservation.client=logedClient;
   boatQuickReservationServices.UPBoatReservation(id, reservation);
   boatQuickReservationServices.createBoatQuickReservationAction(reservation);
   
  }

  console.log("id", id);

  return (
    <form action="javascript:void(0);" onSubmit={saveHandler}>
      <div className="container">
        <div className="row gutters">
          <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <div className="card h-100">
              <div className="card-body">
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h5 className="mb-2 text-primary">Create Reservation</h5>
                  </div>
              
           

            
                </div>
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div className="text-right">
                      <button
                        type="submit"
                        id="submit"
                        name="submit"
                        className="btn btn-success"
                      >
                        Potvrdi
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  );
}
