local userid=KEYS[1];
local prodid=KEYS[2];
local kckey='spike/'..prodid..'/kc';
local userkey='spike/'..prodid..'/user';
local userExists=redis.call("sismember",userkey,userid);
if tonumber(userExists)==1 then
    return 2;
end
local num =redis.call('get',kckey);
if tonumber(num)<0 then
    return 0;
else
    redis.call('decr',kckey);
    redis.call('sadd',userkey,userid);
end
return 1;