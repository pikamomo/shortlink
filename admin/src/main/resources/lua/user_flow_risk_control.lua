-- Set parameters for user access frequency limit
local username = KEYS[1]
local timeWindow = tonumber(ARGV[1]) -- Time window, in seconds

-- Construct the key name for storing user access count in Redis
local accessKey = "short-link:user-flow-risk-control:" .. username

-- Atomically increment the access count and get the incremented value
local currentAccessCount = redis.call("INCR", accessKey)

-- Set the key expiration time
if currentAccessCount == 1 then
    redis.call("EXPIRE", accessKey, timeWindow)
end

-- Return the current access count
return currentAccessCount