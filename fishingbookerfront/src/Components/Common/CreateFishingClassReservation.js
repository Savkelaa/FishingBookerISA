import React, { useRef } from "react";
import { useHistory } from "react-router-dom";
import { useParams } from "react-router-dom";

export default function CreateFishingClassReservation({
  createFishingClassReservationHandler,
}) {
  const startDate = useRef();
  const finishDate = useRef();
  const place = useRef();
  const price = useRef();
  let { id } = useParams();

  const reservation = JSON.parse(localStorage.getItem("reservation"));
  console.log("reservation", reservation);

  function saveHandler(e) {
    createFishingClassReservationHandler({
      startDate: startDate.current.value,
      finishDate: finishDate.current.value,
      place: place.current.value,
      price: price.current.value,
      status: "active",
      client: {
        id: reservation.client.id,
      },
      fishingClass: { id: id },
    });
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
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date_action">Start date:</h6>
                    <input
                      ref={startDate}
                      type="date"
                      className="form-control"
                      id="startAction"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="end_date_action">The last day: </h6>
                    <input
                      ref={finishDate}
                      type="date"
                      className="form-control"
                      id="lastAction"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="website">Place</h6>
                    <input
                      ref={place}
                      type="text"
                      className="form-control"
                      id="place"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="website">Price</h6>
                    <input
                      ref={price}
                      type="text"
                      className="form-control"
                      id="price"
                    />
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
                        Create
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
