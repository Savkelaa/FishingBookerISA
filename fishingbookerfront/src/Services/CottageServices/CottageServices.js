const axios = require("axios");

const cottageServices = {
  getAllCottages: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}cottages`);
  },
  addCottage: (cottage) => {
    return axios.post(`${process.env.REACT_APP_API_URL}cottages`, cottage);
  },
  deleteCottage: (cottageID) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}cottages/${cottageID}`
    );
  },
  updateCottage: (cottage) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}cottages/${cottage.id}`,
      cottage
    );
  },
  getCottagesByOwner: (cottageOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottagesByOwner?cottageOwnerId=${cottageOwnerId}`
    );
  },
  getCottagesById: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottages/${cottageId}`
    );
  },
  getBehavioralRuleByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageBehavioralRulesByCottage?cottageId=${cottageId}`
    )
  },
  getAdditionalServicesByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}additionalServicesByCottage?cottageId=${cottageId}`
    )
  },

  getImagesByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageImage?cottageId=${cottageId}`
    )
  },

  searchCottageByName: (cottageOwnerId, cottageName) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottagesByOwnerAndName?cottageOwnerId=${cottageOwnerId}&cottageName=${cottageName}`
    );
  },

  getWeeklyNumReservationsByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}weeklyCottageReservation?cottageId=${cottageId}`
    )
  },

  getMonthlyNumReservationsByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}monthlyCottageReservation?cottageId=${cottageId}`
    )
  },

  getYearlyNumReservationsByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}yearlyCottageReservation?cottageId=${cottageId}`
    )
  },

  getYearlyIncomeByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}yearlyCottageIncome?cottageId=${cottageId}`
    )
  },

  getMonthlyIncomeByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}monthlyCottageIncome?cottageId=${cottageId}`
    )
  },

  getWeeklyIncomeByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}weeklyCottageIncome?cottageId=${cottageId}`
    )
  },
};

export default cottageServices;
