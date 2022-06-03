import { getRoles } from "@testing-library/react";
import React, { useRef } from "react";
import { BrowserRouter as Link } from "react-router-dom";
import { useParams } from "react-router-dom";

export default function CottageAvailabilityPeriod({
  createDateSpanHandler,
}) {
  const dateFrom = useRef();
  const dateTo = useRef();
  let { id } = useParams();

  function saveHandler(e) {
    createDateSpanHandler({
      startDate: dateFrom.current.value,
      endDate: dateTo.current.value,
      cottage: { id: id},
    });
  }


  return (
    <form action="javascript:void(0);" onSubmit={saveHandler}>
      <div className="container">
        <div className="row gutters">
          <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <div className="card h-100">
              <div className="card-body">
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h5 className="mb-2 text-primary">Availability Period</h5>
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="dateFrom">Availability Period From </h6>
                    <input
                      ref={dateFrom}
                      type="date"
                      className="form-control"
                      id="last"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="dateTo">Availability Period From</h6>
                    <input
                      ref={dateTo}
                      type="date"
                      className="form-control"
                      id="last"
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
                        Set Availability Period
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
